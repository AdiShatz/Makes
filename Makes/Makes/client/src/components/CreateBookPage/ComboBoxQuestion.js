import React, {useState} from "react";



import './ComboBoxQuestion.css';

const ComboBoxQuestion = (props) => {

    return (
        <div>
            <th>
            <select>

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