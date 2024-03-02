import { useNavigate } from "react-router-dom";
import style from "./styled.module.css";
import Navigation from "../Navigation/index.jsx";

const Layout = ({ children }) => {
    const nav = useNavigate();

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