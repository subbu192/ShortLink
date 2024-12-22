import type { Metadata } from "next";
import "./globals.css";
import { font } from "@/libs/font";

export const metadata: Metadata = {
    title: "ShortLink - A URL Shortener",
    description: "A Simple URL Shortening Platform",
};

export default function RootLayout({ children, }: Readonly<{ children: React.ReactNode; }>) {
    return (
        <html lang="en">
            <body className={`${font.className} flex flex-col h-screen bg-zinc-800 text-gray-400`}>
                {children}
            </body>
        </html>
    );
}
