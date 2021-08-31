import React, {useEffect, useState}from "react";
import Card from "../UI/Card";

import './TurningPoint.css';

const TurningPoint = (props) => {
    const [tpData, setTPData] = useState();
    const [styleRight,setRightButtonStyle] = useState();
    const [styleLeft,setLeftButtonStyle] = useState();
    useEffect(
        () => {
                setTPData(props.data);
        },[props,styleRight,styleLeft]
    )

    const clickHandler = (event) =>{
       
        props.onTurningPointChosen(event.target.id);
        if(event.target.id == "left"){
            setRightButtonStyle("");
            setLeftButtonStyle("button-chosen");
        }else{
            
            setRightButtonStyle("button-chosen");
            setLeftButtonStyle("");
        }
    }
    return (
            <Card className="t-p-card">
                {tpData && <p>{tpData.question}</p>}
                {tpData && <button id='left' className={styleLeft} onClick={clickHandler}>{tpData.options[0]}</button>}
                {tpData && <button id='right' className={styleRight} onClick={clickHandler}>{tpData.options[1]}</button>}
            </Card>
    );
}
export default TurningPoint;