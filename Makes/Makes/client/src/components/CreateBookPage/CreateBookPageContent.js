import React, {Children, useState} from "react";
import Questionnaire from "./Questionnaire"
import BookCoverPhoto from "./BookCoverPhoto"
import Button from "../UI/Button";
import './CreateBookPageContent.css';

const CreateBookPageContent = (props) => {

    return (
        <React.Fragment>
        <div id="top-Padding">
                <div style={{textAlign: "center"}}><label id="create-book-subtitle">מלא את השאלון והסיפור שלך תיכף יהיה מוכן</label></div>
                <div className="create-book-page-container">
                    <div className="right-container"><p>התשובות שתספק לשאלון יעזרו לנו לבנות ספר מותאם אישית,
שדות אשר לא ימולאו יקבלו את הערך המקורי מהסיפור.
בסוף מילוי השאלון לחץ על "צור ספר" ותועבר למסך קריאת הספר, שם תוכל לבחור האם ברצונך שהספר ישמר בגלרייה או לא.</p></div> 
                    <div className="left-container"><Questionnaire questions={props.questions} onCreateBook={props.onCreateBook}/> </div>
                </div>                
        </div>
        </React.Fragment>
    );

}
export default CreateBookPageContent;