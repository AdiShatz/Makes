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

        console.log(answersDictonary); // ---------------------> TO DELETE

    }

    const handleUserAnswersUpdated=(key, value)=>{
        answersDictonary[key]=value;
      
        console.log(answersDictonary); // ---------------------> TO DELETE
    }
    


    return (
        <React.Fragment className="questionnaire">
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


            {question.type==="text" && <InputQuestion
             label={question.label}
              id={question.id}
              updateDictionary={handleUserAnswersUpdated}/>}

            </tr>

          ))}
           </table>

        </React.Fragment>
    );

}
export default Questionnaire;