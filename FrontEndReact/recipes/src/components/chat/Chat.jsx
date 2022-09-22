// To do add logged in users, Username.


import { Fragment, useRef, useEffect, useState, } from 'react';
import { Grid, List, ListItem, ListItemText, TextField, FormControl, IconButton, Box, Link } from "@mui/material";
import { ChatMessageDto } from '../../model/ChatMessageDto';
import { FriendDto } from '../../model/FriendDto';
import './Chat.css';
import SendIcon from '@mui/icons-material/Send';
import axios from 'axios';

export default function Chat({ loggedInUser }) {

    const ENTER_KEY_CODE = 13;

    const [isShown, setIsShown] = useState(true);
    const scrollBottomRef = useRef(null);
    const webSocket = useRef(null);
    const [chatMessages, setChatMessages] = useState([]);
    const [user, setUser] = useState('');
    const [message, setMessage] = useState('');
    const [name, setName] = useState('');


    const [friends, setFriends] = useState([new FriendDto(1, "a"),
    new FriendDto(2, "b"),
    new FriendDto(3, "c"),
    new FriendDto(4, "d"),
    new FriendDto(5, "e"),
    new FriendDto(6, "f"),
    new FriendDto(7, "g"),
    new FriendDto(8, "h"),
    new FriendDto(9, "i"),
    new FriendDto(10, "j"),
    new FriendDto(11, "k"),
    new FriendDto(12, "l")]);

    const apiFriends = axios.create({
        baseURL: "http://localhost:8080/friendship"
    })

    useEffect(() => {
        apiFriends.get(`/${loggedInUser.id}`).then(res => {
            setFriends(res.data);
        }).catch(err => {
            console.log(err)
        })
    }, [friends])

    const searchByName = () => {
        apiFriends.get(`/${loggedInUser.id}/${name}`).then(res => {
            setFriends(res.data);
        }).catch(err => {
            console.log(err)
        })
    };

    useEffect(() => {
        console.log('Opening WebSocket');
        webSocket.current = new WebSocket('ws://localhost:8080/Chat');
        webSocket.current.onopen = (event) => {
            console.log('Open: ', event);
        }
        webSocket.current.onclose = (event) => {
            console.log('Close: ', event);
        }
        return () => {
            console.log('Closing WebSocket');
            webSocket.current.close();
        };
    }, []);

    useEffect(() => {
        webSocket.current.onmessage = (event) => {
            const chatMessageDto = JSON.parse(event.data);
            console.log('Message: ', chatMessageDto);
            setChatMessages([...chatMessages, {
                message: chatMessageDto.message
            }]);
            if (scrollBottomRef.current) {
                scrollBottomRef.current.scrollIntoView({ behavior: 'smooth' });
            }
        }
        return () => {

        };
    }, [chatMessages]);

    const handleMessageChange = (event) => { setMessage(event.target.value); }
    const handleEnterKey = (event) => {
        if (event.keyCode === ENTER_KEY_CODE) {
            sendMessage();
        }
    }
    const sendMessage = () => {
        if (message) {
            console.log('Send!');
            webSocket.current.send(
                JSON.stringify(new ChatMessageDto(message))
            );
            setMessage('');
        }
    }

    const listFriends = friends.map((FriendDto, index) =>
        <ListItem key={index} >
            <Link href={`http://localhost:8081/profile/${FriendDto.name}`}>
                <ListItemText primary={`${FriendDto.name}`} />
            </Link>
        </ListItem >
    );

    const listChatMessages = chatMessages.map((chatMessageDto, index) =>
        <ListItem key={index} >
            <ListItemText className={loggedInUser.id === chatMessageDto.id ? 'message received' : 'message'}
                id="chat-window-messages" primary={`${loggedInUser.name}: ${chatMessageDto.message}`} />
        </ListItem >
    );


    const toggleChat = () => {
        setIsShown(current => !current);
    };

    return (
        <Fragment>
            <>
                <button
                    onClick={toggleChat}
                    style={{ position: "fixed", bottom: 10, float: "right", right: 10 }}
                    className="btn btn-dark mb-5 me-5"
                    type="submit"
                >
                    Chat
                    <span className="position-absolute top-0 start-0 translate-middle p-2 bg-danger border border-light rounded-circle mt-1 ms-1">
                        <span className="visually-hidden">New alerts</span>
                    </span>
                </button>
                <div id="chat-container" className="chat-container" style={{ display: isShown ? 'block' : 'none' }}>
                    <div className="center">
                        <div className="contacts">
                            <h2>Your Friends!</h2>

                            <form className="d-flex me-auto" role="search">
                                <input className="form-control me-2" type="search" placeholder="Search for a friend"
                                    onInput={(e) => { setName(e.target.value); searchByName() }} value={name} />
                            </form>
                            <List className="contact-container">
                                {listFriends}
                                <ListItem ref={scrollBottomRef} />
                            </List>
                        </div>
                        <Box className="chat">
                            <Grid className="messages" alignItems="center" id="chat">
                                <Grid id="chat-window">
                                    <List id="chat-window-messages">
                                        {listChatMessages}
                                        <ListItem ref={scrollBottomRef} />
                                    </List>
                                </Grid>

                            </Grid>
                            <Grid className='input' container spacing={2}>
                                <Grid xs={10} item>
                                    <FormControl>
                                        <TextField onChange={handleMessageChange}
                                            onKeyDown={handleEnterKey}
                                            value={message}
                                            label="Type your message..."
                                            variant="outlined" />
                                    </FormControl>
                                </Grid>
                                <Grid xs={2} item>
                                    <IconButton onClick={sendMessage}
                                        aria-label="send" color="primary">
                                        <SendIcon />
                                    </IconButton>
                                </Grid>
                            </Grid>
                        </Box>
                    </div>
                </div>
            </>
        </Fragment >
    )
}