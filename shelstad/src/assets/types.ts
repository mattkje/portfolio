export interface Tool {
  id: number;
  name: string;
  description: string;
  version: string;
  iconId: number;
  screenshot: string;
  price: number;
  link: string;
  createdAt: string;
}

export interface Game {
  id: number;
  name: string;
  description: string;
  version: string;
  iconId: number;
  link: string;
  price: number;
  createdAt: string;
  screenshot: string;
}

export interface Icon {
    id: number;
    fileName: string;
    filePath: string;
}