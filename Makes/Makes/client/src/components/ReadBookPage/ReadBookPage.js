import React, {useState} from "react";
import Header from "../UI/Header";
import ReadBookPageContent from "./ReadBookPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";


const ReadBookPage = (props) => {      

    return (
        <React.Fragment>
            <Header >
                <label>קריאת ספר</label>
                { <button >שמור ספר בגלרייה</button>}
            </Header>
            <ReadBookPageContent pages={props.bookPages}/>
            <Footer>
                <Button onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
                
            </Footer>
        </React.Fragment>
    );
}
export default ReadBookPage;