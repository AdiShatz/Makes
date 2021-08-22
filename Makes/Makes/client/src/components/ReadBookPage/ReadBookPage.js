import React from "react";
import Header from "../UI/Header";
import ReadBookPageContent from "./ReadBookPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import "./ReadBookPage.css";

const ReadBookPage = (props) => {      
    return (
        <React.Fragment>
            <Header >
                <label>{props.bookName}</label>
                {/* { <button >מחק ספר</button>} */}
            </Header>
            <div style={{height: "100px"}}></div>
            <ReadBookPageContent bookPages={props.bookPages}/>
            <Footer>
                <Button onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
                <Button type="button" onClick={props.onGalleryClicked}>הגלריה שלי</Button>
            </Footer>
        </React.Fragment>
    );
}
export default ReadBookPage;