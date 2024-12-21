export type Email = {
  messageId: string;
  from: string;
  replyTo: string;
  destination: {
    to: Array<string>;
    cc: Array<string>;
    bcc: Array<string>;
  };
  subject: string;
  body: {
    html: string;
    text: string;
  };
  at: number;
};
