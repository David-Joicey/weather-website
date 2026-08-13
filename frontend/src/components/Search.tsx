import "./Search.css";

function search() {
    return(
        <div className = "page-container">
            <h1 className = "title">Weather Search</h1>

            <div className = "search-container">
                <input
                className = "search-bar"
                type = "text"
                placeholder = "Location..."
                />
            </div>

        </div>
    )
}
export default search;