// import { Navigation } from "react-router-dom";
import React from 'react';
import style from "./styled.module.css";
import Navigation from '../Navigation';

type LayoutProps = {
    children: React.ReactNode;
}

const Layout = ({ children } : LayoutProps) => {
    // const nav = useNavigate();

    // const onClickHeader = () =>{
    //     nav(`/`);
    // }


    return (
        <div>
            <main className={style.main}>{children}</main>
            <Navigation />
        </div>
    );
}

export default Layout;