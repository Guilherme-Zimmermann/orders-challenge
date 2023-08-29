import { useState, useEffect } from "react"
import { useMenuDataMutate } from "../../hooks/useMenuDataMutate";
import { MenuData } from "../../interface/MenuData";

import "./modal.css"

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: any): void
}

interface ModalProps {
    closeModal(): void
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={event => updateValue(event.target.value)}></input>
        </>
    )
}

export function CreateModal({ closeModal }: ModalProps){
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(0);
    const [imgUrl, setImgUrl] = useState("");
    const { mutate, isSuccess } = useMenuDataMutate();

    const submit = () => {
        const menuData: MenuData = {
            title,
            description,
            price,
            imgUrl
        }
        mutate(menuData)
    }

    useEffect(() => {
        if(!isSuccess) return
        closeModal();
    }, [isSuccess])

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2>Cadastre um novo item no cardápio</h2>
                <form className="input-container">
                    <Input label="Título" value={title} updateValue={setTitle}/>
                    <Input label="Descrição" value={description} updateValue={setDescription}/>
                    <Input label="Preço" value={price} updateValue={setPrice}/>
                    <Input label="Imagem" value={imgUrl} updateValue={setImgUrl}/>
                </form>
                <button onClick={submit} className="btn-secondary">Postar</button>
            </div>
        </div>
    )
}