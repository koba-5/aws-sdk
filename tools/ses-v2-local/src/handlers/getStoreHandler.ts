import { Request, Response } from "express";
import { getStoreReadOnly } from "../store";

export const getStoreHandler = (_: Request, res: Response) => {
  const data = getStoreReadOnly();
  res.status(200).send({ data });
};
