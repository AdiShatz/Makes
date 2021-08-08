import React, {useState} from "react";
import Button from "../UI/Button";


import './AdminPageContent.css';

const AdminPageContent = (props) => {

    return (
        <div className="admin-container">

         <Button>מחק טמפלייט מהתצוגה</Button>
         <Button>הוסף טמפלייט לתצוגה</Button>
         <Button>מחק משתמש קיים</Button>

        </div>
    );
}

export default AdminPageContent;