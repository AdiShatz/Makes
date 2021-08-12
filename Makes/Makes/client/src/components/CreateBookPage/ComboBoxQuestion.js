import React, {useState} from "react";



import './ComboBoxQuestion.css';

const ComboBoxQuestion = (props) => {

    const handleChange = (event) => {
        
        // props.setUserAnswer([props.id, event.target.value]);

        props.updateDictionary(props.id, event.target.value);
       
      }


    return (
        <div className="comboquest">
            <th>
            <select onChange={handleChange}>

            {props.options.map((option) => (
            <option value={option}>
                {option}
            </option>
          ))}

            </select>
            </th>

            <th>
            <label>{props.label}</label>
            </th>

        </div>
    );



}
export default ComboBoxQuestion;