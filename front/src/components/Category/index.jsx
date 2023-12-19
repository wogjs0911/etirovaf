import style from "./styled.module.css";

const Category = () => {

    return (
        <div className= { style.category_form }>
            <div className= { style.category_list }>
                <div>
                    <button className={ style.all_category }>전체</button>
                </div>
                <div>
                    <button className={ style.basic_category }>디자이너</button>
                </div>
                <div>
                    <button className={ style.basic_category }>개발자</button>
                </div>
                <div>
                    <button className={ style.basic_category }>기획자</button>
                </div>
            </div>
        </div>
    );
}

export default Category;