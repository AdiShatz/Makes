import { ReactMediaRecorder } from "react-media-recorder";

const RecordView = () => (
  <div>
    <ReactMediaRecorder
      audio
      render={({ status, startRecording, stopRecording, mediaBlobUrl }) => (
        <div>
          <p>{status}</p>
          <button onClick={startRecording}>הקלט</button>
          <button onClick={stopRecording}>עצור</button>
          <audio src={mediaBlobUrl} controls autoplay />
        </div>
      )}
    />
  </div>
);

export default RecordView;