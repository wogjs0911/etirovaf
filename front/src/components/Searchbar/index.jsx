import style from "./styled.module.css";
import globalStyle from "../../styles/style.module.css";
import { useState, useEffect } from "react";
import {useNavigate} from "react-router-dom";

const Searchbar = ({ q }) => {
    const [search, setSearch] = useState("");
    const nav = useNavigate();

    useEffect(() => {
        setSearch(q);
    }, [q]);

    const onChangeSearch = (e) => {
        setSearch(e.target.value);
    };

    const onKeyDown = (e) => {
        if (e.keyCode === 13) {
            onClickSearch();
        }
    };

    const onClickSearch = () => {
        if (search !== "") {
            nav(`/search?q=${search}`);
        }
    };

    return (
        <div className={style.container}>
            <div className={style.search_form}>
                <h1 className={`${globalStyle.icon} ${style.icon_dodbogi}`}>돋보기</h1>
                <input
                    className={style.search_input}
                    value={search || ''}
                    onKeyDown={onKeyDown}
                    onChange={onChangeSearch}
                    placeholder="검색어를 입력하세요..."
                />
            </div>
            <div className={style.category_setting}>
                <h1 className={`${globalStyle.icon} ${style.icon_category_setting}`}>알림</h1>
            </div>
        </div>
    );
}

export default Searchbar;