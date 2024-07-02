import React from 'react';
import { Link } from 'react-router-dom';
import account from './media/account.png'


const Topico = ({topic}) => {
    
    const { id, titulo, mensaje, fecha_creacion, usuario_id, respuestas } = topic
 
    return (
        <div className='topico-container'>
            <Link to={`/detail/${id}`} className='topico'>
                <div className='topico-l'>
                    <div className='topico-titulo'>{titulo}</div>
                    <div className='topico-mensaje'>{mensaje}</div>
                    <div className='topico-fecha'>{fecha_creacion}</div>
                </div>
                <div className='topico-r'>
                    <div className='topico-respuestas'>
                        <div>{respuestas.length}</div>
                        <div>respuestas</div>
                    </div>
                    <img src={account} width={50} height={50}  alt=''/>
                    <div className='topico-div-autor'>
                        <p>por</p>
                        <div className='topico-autor'>{usuario_id.nombre}</div>
                    </div>
                    
                </div>
            </Link>
        </div> 
    )   
}
  
  export default Topico;


