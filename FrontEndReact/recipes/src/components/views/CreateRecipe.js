import { React } from 'react'

// Bootstrap
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

// Components
import CustomForm from '../CustomForm'

function CreateRecipe(props) {
    return (
        <Container>
            {props.changeDocTitle("Create Recipe")}
            <h1>Create Recipe</h1>
            <Row>
                <Col>
                    title
                </Col>
                <Col>
                    CHOOSE type
                </Col>
                <Col>
                    CHECK sell recipe
                </Col>
            </Row>
            <Col>
                photo
            </Col>
            <Row>
                <Col>
                    ingredients
                </Col>
                <Col>
                    <Row>
                        description
                    </Row>
                    <Row>
                        instructions
                    </Row>
                </Col>
            </Row>
            <Row>
                <Col>
                    utensils
                </Col>
                <Col>
                    video
                </Col>
            </Row>
            <Row>
                BUTTON create recipe
            </Row>
            {/* <CustomForm /> */}
        </Container>
    )
}

export default CreateRecipe