import React, {useState} from "react";



import './ComboBoxQuestion.css';

const ComboBoxQuestion = (props) => {

    const handleChange = (event) => {
        
        // props.setUserAnswer([props.id, event.target.value]);

        props.updateDictionary(props.id, event.target.value);
       
      }


    return (
        <Fragment>
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

        </Fragment>
    );



}
export default ComboBoxQuestion;