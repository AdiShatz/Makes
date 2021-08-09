import React, {useState} from "react";
import InputQuestion from "./InputQuestion";
import ComboBoxQuestion from "./ComboBoxQuestion";
import Button from "../UI/Button"

import './Questionnaire.css';

let answersDictonary= new Object();

const Questionnaire = (props) => {

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
    
          const submitHandler = () => {
                props.onCreateBook(answersDictonary);
              }
    
        

    return (
        <div className="questionnaire">
            {setDefaultValues()}
           <table>
            {props.questions.map((question) => (

            <tr>

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

            </tr>

          ))}
           </table>
            
           <Button onClick={submitHandler}> צור ספר </Button>

        </div>
    );

}
export default Questionnaire;