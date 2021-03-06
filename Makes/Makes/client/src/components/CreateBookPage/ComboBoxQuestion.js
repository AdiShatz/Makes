import React from "react";

import './ComboBoxQuestion.css';

const ComboBoxQuestion = (props) => {

    const handleChange = (event) => {
        props.updateDictionary(props.id, event.target.value);
      }

    return (
        <div className="comboquest">
             <label>{props.label}</label>
            <select onChange={handleChange}>

            {props.options.map((option) => (
            <option value={option}>
                {option}
            </option>
          ))}

            </select>
        </div>
    );

}
export default ComboBoxQuestion;