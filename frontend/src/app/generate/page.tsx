import InputBox from "@/components/InputBox";

export default function InputFormPage() {

    return (
        <div className="flex-1 flex flex-col justify-center items-center">
            <div className="flex flex-col justify-center items-center">
                <h1 className="text-[80px] font-semibold text-white">ShortLink</h1>
            </div>
            <InputBox />
        </div>
    )
}