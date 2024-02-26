import axios from "axios";

const baseURL = "http://localhost:8080/api/auth"; // API adresini sabit bir değişkene atadık

export default class authService {

    getLogin(username, password) {
        console.log("getLogin Requested")
        return axios({
            url: `${baseURL}/login`,
            method: "POST",
            data: {
                username: username,//window.btoa(userInfo.username),
                password: password, //window.btoa(userInfo.password) 
            }
        });

    }
}