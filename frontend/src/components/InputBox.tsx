"use client";

import Link from "next/link";
import { useRef, useState } from "react"

export default function InputBox() {
    const [ shortUrl, setShortUrl ] = useState<string>("");
    const [ errorMsg, setErrorMsg ] = useState<string>("");

    const TitleInput = useRef<HTMLInputElement>(null);
    const LongUrlInput = useRef<HTMLInputElement>(null);

    const submitForm = async () => {
        const title = TitleInput.current?.value;
        const longUrl = LongUrlInput.current?.value;

        console.log(process.env.NEXT_PUBLIC_SERVER_URL)

        const res = await fetch(`${process.env.NEXT_PUBLIC_SERVER_URL}/generate`, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ title, longUrl }),
        })
        if (res.ok) {
            setErrorMsg("");
            const data = await res.json();
            setShortUrl(data.shortUrl);
        } else {
            setErrorMsg("Error generating Short URL. Please try again.");
        }
    }

    return (
        <div className="flex flex-col justify-center items-start gap-5 w-[500px] px-10 py-10 border-2 border-zinc-400 rounded-lg">
            <div className="flex flex-col justify-center items-center w-full gap-2">
                <h2 className="text-2xl text-zinc-200 font-semibold">Generate Short URL</h2>
                <p className="text-[14px] text-center">You need to enter Original Long URL and a unique Title to better identify it. We will convert it into Short URL for you.</p>
            </div>
            <div className="flex flex-col gap-2 w-full">
                <label htmlFor="title" className=" text-zinc-200">Title:</label>
                <input ref={TitleInput} type="text" id="title" name="title" className="bg-transparent border-2 border-zinc-500 px-3 py-2 rounded-md w-full" />
            </div>
            <div className="flex flex-col gap-2 w-full">
                <label htmlFor="longUrl" className=" text-zinc-200">Original Long URL:</label>
                <input ref={LongUrlInput} type="text" id="longUrl" name="longUrl" className="bg-transparent border-2 border-zinc-500 px-3 py-2 rounded-md w-full" />
            </div>
            <button onClick={submitForm} className="mt-2 px-4 py-2 border-2 border-zinc-500 rounded-md font-semibold hover:bg-zinc-500 hover:text-white duration-300">Submit</button>
            <div className={`${(shortUrl.length > 0) ? "flex" : "hidden"} flex-col gap-1 w-full`}>
                <p className="text-center mb-2">--------------------------------------------------------</p>
                <h4 className="text-lg text-zinc-200 font-medium">Generated Short URL: </h4>
                <Link target="_blank" href={shortUrl} className="text-zinc-400 border-b-2 border-zinc-400 w-max">{shortUrl}</Link>
            </div>
            <div className={`${(errorMsg.length > 0) ? "flex" : "hidden"} flex-col gap-1 w-full`}>
                <p className="text-center mb-2">--------------------------------------------------------</p>
                <h4 className="text-lg text-zinc-200 font-medium">Error: </h4>
                <p className="text-red-500 w-max">{errorMsg}</p>
            </div>
        </div>
    )
}