import React, {useState} from "react";
import Questionnaire from "./Questionnaire"
// import CreateBookButton from "./CreateBookButton"
import BookCoverPhoto from "./BookCoverPhoto"
import Button from "../UI/Button"

import './CreateBookPageContent.css';

const CreateBookPageContent = (props) => {

    return (
        <React.Fragment className="create-book-page-content">
            <Questionnaire questions={props.questions}/> 
            {/* <CreateBookButton/> */}
            <Button onClick={props.onCreateBook}> צור ספר </Button>
            <BookCoverPhoto/>
        </React.Fragment>
    );



}
export default CreateBookPageContent;