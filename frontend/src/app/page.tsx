import Link from "next/link";

export default function Home() {

    return (
        <div className="flex-1 flex flex-col justify-center items-center gap-6">
            <div className="flex flex-col justify-center items-center">
                <h1 className="text-[80px] font-semibold text-white">ShortLink</h1>
                <p className="text-[25px]">A Simple URL Shortening Platform</p>
            </div>
            <Link href={"/generate"} className="mt-2 px-4 py-2 border-2 border-zinc-500 rounded-md font-semibold hover:bg-zinc-500 hover:text-white duration-300">Try Now</Link>
        </div>
    )
}