import { Request, Response } from "express";
import { saveEail } from "../store";
import { Email } from "../types/Email";

export const sendEmailV2Handler = (req: Request, res: Response) => {
  const messageId = `ses-${Math.floor(Math.random() * 900000000 + 100000000)}`;
  const email: Email = {
    messageId,
    from: req.body.FromEmailAddress,
    replyTo: req.body.ReplyToAddresses ?? [],
    destination: {
      to: req.body.Destination?.ToAddresses ?? [],
      cc: req.body.Destination?.CcAddresses ?? [],
      bcc: req.body.Destination?.BccAddresses ?? [],
    },
    subject: req.body.Content.Simple.Subject.Data,
    body: {
      html: req.body.Content.Simple.Body.Html?.Data,
      text: req.body.Content.Simple.Body.Text?.Data,
    },
    at: Math.floor(new Date().getTime() / 1000),
  };
  saveEail(email);
  res.status(201).send();
};
