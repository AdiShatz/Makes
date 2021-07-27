import React, {useState} from "react";
import Questionnaire from "./Questionnaire"
import CreateBookButton from "./CreateBookButton"
import BookCoverPhoto from "./BookCoverPhoto"


import './CreateBookPageContent.css';

const CreateBookPageContent = (props) => {

    return (
        <div className="create-book-page-content">
            <Questionnaire questions={props.questions}/> 
            <CreateBookButton/>
            <BookCoverPhoto/>
        </div>
    );



}
export default CreateBookPageContent;