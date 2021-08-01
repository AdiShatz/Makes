import React, {Fragment, useState} from "react";
import Header from "../UI/Header";
import MainPageContent from "./MainPageContent";
import Footer from "../UI/Footer";
import GreetingLabel from "./GreetingLabel";
import Button from "../UI/Button";
import AuthForm from "../Auth/AuthForm";

import "./GalleryPage.css";

const GalleryPage = (props) => {

    return (
        <React.Fragment>
            {loginIsShown && <AuthForm onClose={hideLoginHandler} />}
            <Header >
                <h1>הגלריה שלי</h1>
            </Header>
            <GalleryPageContent items={props.items} onBookItemClicked={props.on}/>
            <Footer>
            <Button type="button" onClick={}>דף הבית</Button>
            </Footer>
        </React.Fragment>
    );
}
export default GalleryPage;