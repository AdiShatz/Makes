import React, {useState} from "react";
import BookPage from "../Books/BookPage";
import Button from "../UI/Button";


import './AdminPageContent.css';

const AdminPageContent = (props) => {

   

    return (
        <React.Fragment>
         <Button>מחק ספר בתצוגה</Button>
         <Button>הוסף ספר לתצוגה</Button>
         <Button>מחק משתמש קיים</Button>


        </React.Fragment>
    );
}

export default AdminPageContent;