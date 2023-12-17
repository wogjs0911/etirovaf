import { useNavigate } from "react-router-dom";
import style from "./styled.module.css";

export default function Layout({ children }) {
    const nav = useNavigate();

    // const onClickHeader = () =>{
    //     nav(`/`);
    // }

    return (
        <div>
            <main className={style.main}>{children}</main>
        </div>
    );
}