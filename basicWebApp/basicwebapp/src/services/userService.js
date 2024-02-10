import axios from "axios";
export default class userService {
    getUsers() {
        console.log("getUsers Requested")
        return axios.get("http://localhost:8080/api/users/getall")
    }
    getUserById(id) {
        console.log("getUserById Requested")
        return axios.get(`http://localhost:8080/api/users/getById?id=${id}`)
    }

    deleteUserById(id) {
        console.log("deleteUserById Requested")
        return axios.get(`http://localhost:8080/api/users/deleteById?id=${id}`)
    }
}