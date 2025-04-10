export interface Tool {
  id: number;
  name: string;
  description: string;
  version: string;
  iconId: number;
  screenshot: string;
  price: number;
  link: string;
  video: string;
  createdAt: string;
}

export interface Game {
  id: number;
  name: string;
  description: string;
  version: string;
  iconId: number;
  link: string;
  video: string;
  price: number;
  createdAt: string;
  screenshot: string;
}

export interface Icon {
    id: number;
    fileName: string;
    filePath: string;
}