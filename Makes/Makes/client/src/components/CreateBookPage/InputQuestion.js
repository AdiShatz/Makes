import React from "react";

import './InputQuestion.css';

const InputQuestion = (props) => {

    
    const handleChange = (event) => {
        props.updateDictionary(props.id, event.target.value);
      }

    return (
        <div className="inpquest">
            <label>{props.label}</label>
            <input type="text" dir = "rtl" onChange={handleChange} />
            
        </div>
    );
}
export default InputQuestion;