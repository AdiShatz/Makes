import React, {useState} from "react";



import './InputQuestion.css';

const InputQuestion = (props) => {

    return (
        <div>
            <input type="text"></input>
            <label>{props.label}</label>
        </div>
    );



}
export default InputQuestion;