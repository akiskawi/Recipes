// To do add logged in users, Username.


import { Fragment, useRef, useEffect, useState, } from 'react';
import { Container, Paper, Typography, Divider, Grid, List, ListItem, ListItemText, TextField, FormControl, IconButton, Box } from "@mui/material";
import { ChatMessageDto } from '../../model/ChatMessageDto';
import './Chat.css';
import SendIcon from '@mui/icons-material/Send';
import ReorderIcon from '@mui/icons-material/Reorder';
import axios from 'axios';

export default function Chat() {

    const ENTER_KEY_CODE = 13;

    const [isShown, setIsShown] = useState(true);
    const scrollBottomRef = useRef(null);
    const webSocket = useRef(null);
    const [chatMessages, setChatMessages] = useState([]);
    const [user, setUser] = useState('');
    const [message, setMessage] = useState('');
    const [friends, setFriends] = useState();
    // const apiFriends = axios.create({
    //     baseURL: "http://localhost:8080/friends/"
    // })

    // useEffect(() => {
    //     apiFriends.get('/userId').then(res => {
    //         setFriends(res.data);
    //     }).catch(err => {
    //         console.log(err)
    //     })
    // }, [apiFriends])

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
                user: chatMessageDto.user,
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
                JSON.stringify(new ChatMessageDto(user, message))
            );
            setMessage('');
        }

    }

    // const listFriends = friends.map((FriendsDto, index) =>
    //     <ListItem key={index} >
    //         <ListItem id="chat-window-messages" primary={`${FriendsDto.user}`} />
    //     </ListItem >
    // );

    const listChatMessages = chatMessages.map((chatMessageDto, index) =>
        <ListItem key={index} >
            <ListItemText id="chat-window-messages" primary={`${chatMessageDto.user}: ${chatMessageDto.message}`} />
        </ListItem >
    );

    // var chat = document.getElementById('chat');
    // // chat.scrollTop = chat.scrollHeight - chat.clientHeight;

    const toggleChat = (event) => {
        setIsShown(current => !current);
    };

    return (
        <Fragment>
            <>
                <button
                    onClick={toggleChat}
                    style={{ position: "fixed", bottom: 10, float: "right", right: 10 }}
                    className="btn btn-outline-success mb-5 me-5"
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
                            <div className="contact-container">
                                {/* <List id="chat-window-messages">
                                    {listFriends}
                                </List> */}
                            </div>
                        </div>
                        <Box className="chat"
                            sx={{
                                height: "fit-container",
                            }}>
                            <Grid className="messages" spacing={4} alignItems="center" id="chat">
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