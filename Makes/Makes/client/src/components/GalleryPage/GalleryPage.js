import React, {Fragment, useState} from "react";
import Header from "../UI/Header";
import Footer from "../UI/Footer";
import Button from "../UI/Button";
import GalleryPageContent from "./GalleryPageContent";


import "./GalleryPage.css";

const GalleryPage = (props) => {

    return (
        <React.Fragment>
            <Header >
                <h1>הגלריה שלי</h1>
            </Header>
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