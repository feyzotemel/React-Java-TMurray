import axios from "axios";

const baseURL = "http://localhost:8080/api/users"; // API adresini sabit bir değişkene atadık

export default class userService {
    getUsers() {
        console.log("getUsers Requested")
        return axios.get(`${baseURL}/getall`)
    }
    getUserById(id) {
        console.log("getUserById Requested")
        return axios.get(`${baseURL}/getById?id=${id}`)
    }

    deleteUserById(id) {
        console.log("deleteUserById Requested")
        return axios.get(`${baseURL}/deleteById?id=${id}`)
    }
}