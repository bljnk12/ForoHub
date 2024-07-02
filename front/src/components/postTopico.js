import React, { useState, useEffect } from "react";

export default function PostTopic() {

    const [token, setToken] = useState();
    const [usuarioId, setUsuarioId] = useState();

    useEffect(() => {
        const token = localStorage.getItem('token');
        setToken(token);
    },[token]);

    useEffect(() => {
        const usuarioId = localStorage.getItem('id');
        setUsuarioId(usuarioId)
    },[usuarioId]);

    
    const [titulo, setTitulo] = useState()
    const [mensaje, setMensaje] = useState()
   
    const today = new Date();
    const yyyy = today.getFullYear();
    let mm = today.getMonth() + 1;
    let dd = today.getDate();

    if (dd < 10) dd = '0' + dd;
    if (mm < 10) mm = '0' + mm;

    const formattedToday = dd + '/' + mm + '/' + yyyy;

    const myHeaders = new Headers();

    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Authorization", `Bearer ${token}`);

    const topico = {
        "titulo": titulo,
        "mensaje": mensaje,
        "fecha_creacion": formattedToday,
        "status": true,
        "usuario_id": {
            "id_usuario": usuarioId
        },
        "curso_id": {
            "id_curso": 1
        }
    };
 
const options = {
    method: 'POST',
    headers: myHeaders,
    body: JSON.stringify(topico),
    redirect: "follow"
  };

  let postData = async ()=> {
    fetch('http://localhost:8080/topicos', options)
  }


    return (
        <div className="f-topico-m">
            <div className="f-topico-i">
                <form onSubmit={postData}>
                <input className="f-topico-titulo" type="text" placeholder="Titulo" onChange={(e) => {setTitulo(e.target.value)}}/>
                <textarea className="f-topico-mensaje" type="text" placeholder="Escribe tu mensaje" resize="none" onChange={(e) => {setMensaje(e.target.value)}}/>
                <input className="f-topico-submit" type="submit" value="Enviar"/>
                {/* <button className="test" onClick={postData}>test</button> */}
                </form>
            </div>
        </div>
      
    )
}