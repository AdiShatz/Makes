import React, {useState} from "react";
import Header from "../UI/Header";
import AdminPageContent from "./AdminPageContent";
import Footer from "../UI/Footer";
import Button from "../UI/Button";


const AdminPage = (props) => {        

    return (
        <React.Fragment>
            <Header >
               
            </Header>

            <AdminPageContent pages={DUMMY_BOOK}/>

            <Footer>
                <Button onClick={props.onBackToMainMenuButtonClicked}>דף הבית</Button>
            </Footer>
        </React.Fragment>
    );
}
export default AdminPage;