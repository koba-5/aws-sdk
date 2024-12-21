import { Request, Response } from "express";
import { cleanEmail } from "../store";

export const cleanStoreHandler = (_: Request, res: Response) => {
  cleanEmail();
  res.status(200).send({ message: "OK" });
};
