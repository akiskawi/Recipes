// axios import
import http from "../http-common"

const getFirst = () => {
    http.get("recipe/showrecipe1").then(res => {
        return res;
    })
}


const RecipeService = {
    getFirst
};

export default RecipeService