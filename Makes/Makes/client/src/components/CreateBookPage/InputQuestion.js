import React, {useState} from "react";

import './InputQuestion.css';

const InputQuestion = (props) => {

    
    const handleChange = (event) => {
        props.updateDictionary(props.id, event.target.value);
      }

    return (
        <React.Fragment>
            <input type="text" dir = "rtl" onChange={handleChange} />
            <label>{props.label}</label>
        </React.Fragment>
    );



}
export default InputQuestion;