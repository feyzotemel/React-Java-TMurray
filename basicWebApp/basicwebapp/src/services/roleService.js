import axios from "axios";
export default class roleService {
    getRoles() {
        console.log("getRoles Requested")

        return axios.get("http://localhost:8080/api/roles/getall")
    }
}