export interface Tool {
  id: number;
  name: string;
  description: string;
  version: string;
  icon_id: number;
  screenshot: string;
  price: number;
  link: string;
  video: string;
  created_at: string;
}

export interface Game {
  id: number;
  name: string;
  description: string;
  version: string;
  icon_id: number;
  link: string;
  video: string;
  price: number;
  created_at: string;
  screenshot: string;
}

export interface Icon {
    id: number;
    fileName: string;
    filePath: string;
}