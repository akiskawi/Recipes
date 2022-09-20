import { Link } from 'react-router-dom';

// Bootstrap
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Image from 'react-bootstrap/Image'

const RecipeItem = ({ recipe, setProfileUser }) => {
    return (
        <div>
            <h1>RECIPE ITEM</h1>
            <div className="recipe-info">
                <Row>
                    <Col xs={4}>
                        Title
                        <div className="square border rounded" style={{ padding: '10px', maxHeight: '50px', overflow: 'auto' }}>
                            TITLE FROM DB
                        </div>
                    </Col>
                    <Col xs={{ span: 3, offset: 1 }}>
                        Type
                        <div className="square border rounded" style={{ padding: '10px', maxHeight: '50px', overflow: 'auto' }}>
                            TYPE FROM DB
                        </div>
                    </Col>
                    <Col xs={{ span: 3, offset: 1 }}>
                        Owner
                        <div className="square border rounded" style={{ padding: '10px', maxHeight: '50px', overflow: 'auto' }}>
                            OWNER FROM DB
                        </div>
                    </Col>
                </Row>
                <Col>
                    <div className="square border rounded" style={{ padding: '10px', maxHeight: '50px', overflow: 'auto' }}>
                        <Image src='' alt='recipe photo' />
                    </div>
                </Col>
                <Row>
                    <Col>
                        {/* <Form.Group className="mb-6" controlId="recipeInstructions">
                            <Form.Label>Instructions</Form.Label>
                            <Form.Control style={{ height: '350px' }} size="lg" aria-label="With textarea" as='textarea' placeholder="type recipe's instructions"></Form.Control>
                            <Form.Text className="text-muted">
                                seperated by commas (,)
                            </Form.Text>
                        </Form.Group> */}
                    </Col>
                    <Col>
                        <Row>
                            {/* <Form.Group className="mb-6" controlId="recipeDescription">
                                <Form.Label>Description</Form.Label>
                                <Form.Control style={{ height: '50px' }} type='text' placeholder="type recipe's description"></Form.Control>
                                <Form.Text className="text-muted">
                                    e.g.: fresh made horse meatballs
                                </Form.Text>
                            </Form.Group> */}
                        </Row>
                        <Row>
                            {/* <Form.Group className="mb-6" controlId="recipeIngredients">
                                <Form.Label>Ingredients</Form.Label>
                                <Form.Control style={{ height: '230px' }} size="lg" aria-label="With textarea" as='textarea' placeholder="type recipe's ingredients"></Form.Control>
                                <Form.Text className="text-muted">
                                    seperated by commas (,)
                                </Form.Text>
                            </Form.Group> */}
                        </Row>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        {/* <Form.Group className="mb-6" controlId="recipeUtensils">
                            <Form.Label>Utensils</Form.Label>
                            <Form.Control size="lg" aria-label="With textarea" as='textarea' placeholder="type recipe's utensils"></Form.Control>
                            <Form.Text className="text-muted">
                                seperated by commas (,)
                            </Form.Text>
                        </Form.Group> */}
                    </Col>
                    <Col>
                        {/* <div className="d-grid gap-2" style={{ height: '135px' }}>
                            <Button variant="primary" size="lg">
                                Add video for your recipe
                            </Button>
                        </div> */}
                    </Col>
                </Row>
                <Row>
                    {/* <div className="d-grid gap-2">
                        <Button variant="success" size="lg">
                            Create Recipe
                        </Button>
                    </div> */}
                </Row>
                {/* <div className="recipe-title">{recipe.name}</div>
                <div className="recipe-type">{recipe.type}</div>
                <div className="recipe-type">{recipe.paid ? 'True' : 'False'}</div> */}
                <div className="bts">{/*TODO:*/}EDIT/SAVE TO DO</div>

                <div className="">Link</div>
                {/* <Link to={`/profile/${recipe.ownerId.name}`} onClick={() => { setProfileUser(recipe.ownerId) }}>
                    <div className="recipe-author">{recipe.ownerId.name}</div>
                </Link> */}
            </div>
        </div >
    )
}

export default RecipeItem