import axios from "axios";
export default class userService {
    getUsers() {
        console.log("getUsers Requested")
        return axios.get("http://localhost:8080/api/users/getall")
    }
}