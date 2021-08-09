import React, {useState} from "react";
import InputQuestion from "./InputQuestion";
import ComboBoxQuestion from "./ComboBoxQuestion";

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

    const handleUserAnswersUpdated=(key, value)=>{
        answersDictonary[key]=value;
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
            updateDictionary={handleUserAnswersUpdated}
               /> }


            {question.type==="input" && <InputQuestion
             label={question.label}
              id={question.id}
              updateDictionary={handleUserAnswersUpdated}/>}

            </tr>

          ))}
           </table>

        </div>
    );

}
export default Questionnaire;