import React, {useState} from "react";
import InputQuestion from "./InputQuestion";
import ComboBoxQuestion from "./ComboBoxQuestion";

import './Questionnaire.css';

const Questionnaire = (props) => {

    // const filteredInputQuestions = props.questions.filter((item) => {
    //              return item.type === "input";
    //            });

    // const filteredComboBoxQuestions = props.questions.filter((item) => {
    // return item.type === "combo";
    // });

    

    return (
     <div className="questionnaire">
           <table>
            {props.questions.map((question) => (
                <tr>

            {question.type==="combo" && <ComboBoxQuestion label={question.label} options={question.options}/>}

            {question.type==="text" && <InputQuestion label={question.label}/>}

            
            </tr>
          ))}
           </table>

           </div>
    );

}
export default Questionnaire;