import React from "react";
import Header from "../UI/Header";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import GalleryPageContent from "./GalleryPageContent";

import "./GalleryPage.css";

const GalleryPage = (props) => {

    return (
        <React.Fragment>
            <Header >
                <label style={{paddingRight:"30px"}}>הגלריה שלי</label>
            </Header>
            <div style={{height: "100px"}}></div>
            <GalleryPageContent 
            items={props.items}
            onGalleryBookItemClicked={props.onGalleryBookItemClicked}
            onGalleryItemDeletion={props.onGalleryItemDeletion}/>
            <Footer>
            <Button type="button" onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
            </Footer>
        </React.Fragment>
    );
}
export default GalleryPage;