import React, {useRef} from "react";
import InputQuestion from "./InputQuestion";
import ComboBoxQuestion from "./ComboBoxQuestion";
import Button from "../UI/Button"

import './Questionnaire.css';

let answersDictonary= new Object();

const Questionnaire = (props) => {
    const chosenBookNameInputRef = useRef(localStorage.getItem("bookName"));

    const setDefaultValues=()=>{
        props.questions.map(question => {
            if(question.type==="combo"){
                answersDictonary[question.id]=question.options[0];
            }
            else{
                answersDictonary[question.id]=""; 
            }
        });
    }

    const userAnswersUpdatedHandler=(key, value)=>{
        answersDictonary[key]=value;
          }
    
          const createHandler = () => {
                props.onCreateBook(answersDictonary, chosenBookNameInputRef.current.value);
              }

    return (
        <div className="questionnaire">
            {setDefaultValues()}
           <form>
           <div className="inpquest"> 
                <label>שם הסיפור</label>
                <input type='bookName' id='bookName' dir = "rtl" required ref={chosenBookNameInputRef}/> 
            </div>
            {props.questions.map((question) => (

            <div className="">

            {question.type==="combo" && <ComboBoxQuestion 
            label={question.label}
            options={question.options}
            id={question.id} 
            updateDictionary={userAnswersUpdatedHandler}
               /> }


            {question.type==="input" && <InputQuestion
             label={question.label}
              id={question.id}
              updateDictionary={userAnswersUpdatedHandler}/>}

            </div>

          ))}
                     <div id="create-book-button"><Button onClick={createHandler}> צור ספר </Button></div>
           </form>

        </div>

        
    );

}
export default Questionnaire;